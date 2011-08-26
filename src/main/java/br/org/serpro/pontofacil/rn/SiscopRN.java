/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.serpro.pontofacil.rn;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import br.org.serpro.pontofacil.entity.Relogio;
import br.org.serpro.pontofacil.entity.Turno;
import br.org.serpro.pontofacil.exception.LoginFalhou;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

public class SiscopRN {

    public static DefaultHttpClient conexaoSiscop = null;
    /**
     * Log da classe
     */
    private Log log = LogFactory.getLog(this.getClass());

    public StatusLine doLogin(String cpf, String senha) throws UnsupportedEncodingException, IOException, LoginFalhou {
        SiscopRN.conexaoSiscop = new DefaultHttpClient();

        HttpPost httpPost = new HttpPost("http://siscop.portalcorporativo.serpro/cpf_senha.asp");

        final List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("tx_senha", senha));
        nvps.add(new BasicNameValuePair("tx_cpf", cpf));

        httpPost.setEntity(new UrlEncodedFormEntity(nvps));

        log.info("Conectando com SISCOP");

        HttpResponse response = conexaoSiscop.execute(httpPost);

        StatusLine status = response.getStatusLine();

        HttpEntity entity = response.getEntity();

        EntityUtils.consume(entity);
        
        if (status.getStatusCode() != 302) {
            throw new LoginFalhou(cpf, status);
        }

        return status;
    }

    public Relogio obterPonto() throws Exception {
        HttpGet httpGet = new HttpGet("http://siscop.portalcorporativo.serpro/CadRegPonto.asp");

        log.info("Obtendo ponto");

        HttpResponse response = null;
        try {
            response = conexaoSiscop.execute(httpGet);
        } catch (ClientProtocolException ex) {
            Logger.getLogger(SiscopRN.class.getName()).log(Level.SEVERE, "Falha na conexão", ex);
        } catch (IOException ex) {
            Logger.getLogger(SiscopRN.class.getName()).log(Level.SEVERE, "Falha na conexão", ex);
        }

        StatusLine status = response.getStatusLine();
        if (status.getStatusCode() != 200) {
            Logger.getLogger(SiscopRN.class.getName()).log(Level.SEVERE, "Falha na conexão");
            
            throw new Exception("Falha na conexão");
        }

        final HttpEntity entity = response.getEntity();

        InputStream is = entity.getContent();

        Scanner sc = new Scanner(is, "ISO8859-1");
        String linha = null;

        if (sc.hasNextLine()) {
            sc.nextLine();
        }
        if (sc.hasNextLine()) {
            sc.nextLine();
        }
        if (sc.hasNextLine()) {
            linha = sc.nextLine();
        }

        Relogio relogio = obterApontamentos(is);

        EntityUtils.consume(entity);

        return relogio;
    }

    private Object setRelogioRemoto(Relogio obterApontamentos) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Método que obtem os apontamentos da página do SISCOP
     * 
     * @param data
     * @return
     * @throws ParseException
     */
    private Relogio obterApontamentos(InputStream data) throws ParseException {
        final Scanner scanner = new Scanner(data, "ISO8859-1");
        final String timeRegex = "\\b[0-9]{2}\\:[0-9]{2}\\b";
        final DateFormat dateFormat = new SimpleDateFormat("HH:mm", new Locale(
                "pt", "BR"));

        final Relogio relogio = new Relogio();

        String temp;
        while (scanner.hasNext()) {

            if (scanner.findInLine("ptNorm\">1º Período</td>") != null) {
                scanner.nextLine();
                if (scanner.findInLine("Entrada") != null
                        && (temp = scanner.findInLine(timeRegex)) != null) {
                    relogio.setHrEnt1Turno(dateFormat.parse(temp));

                } else if (scanner.findInLine("Saída") != null
                        && (temp = scanner.findInLine(timeRegex)) != null) {
                    relogio.setHrSai1Turno(dateFormat.parse(temp));

                }
            }

            if (scanner.findInLine("ptNorm\">2º Períod") != null) {
                scanner.nextLine();
                if (scanner.findInLine("Entrada") != null
                        && (temp = scanner.findInLine(timeRegex)) != null) {
                    relogio.setHrEnt2Turno(dateFormat.parse(temp));

                } else if (scanner.findInLine("Saída") != null
                        && (temp = scanner.findInLine(timeRegex)) != null) {
                    relogio.setHrSai2TurnoExt(dateFormat.parse(temp));

                }
            }

            if (scanner.findInLine("rdPer1hee") != null) {
                scanner.nextLine();
                if ((temp = scanner.findInLine(timeRegex)) != null) {
                    relogio.setHrEnt1TurnoExt(dateFormat.parse(temp));
                }
            }
            if (scanner.findInLine("rdPer1hes") != null) {
                scanner.nextLine();
                if ((temp = scanner.findInLine(timeRegex)) != null) {
                    relogio.setHrSai1TurnoExt(dateFormat.parse(temp));
                }
            }

            if (scanner.findInLine("rdPer2hee") != null) {
                scanner.nextLine();
                if ((temp = scanner.findInLine(timeRegex)) != null) {
                    relogio.setHrEnt2TurnoExt(dateFormat.parse(temp));
                }
            }

            if (scanner.findInLine("rdPer2hes") != null
                    && (temp = scanner.findInLine("\\b[0-9]{2}\\:[0-9]{2}\\b")) != null) {
                relogio.setHrSai2TurnoExt(dateFormat.parse(temp));
            }

            scanner.nextLine();
        }

        return relogio;
    }

    /**
     * Abre página do SISCOP e realiza apontamento
     * 
     * @param cpf
     *            CPF do usuário
     * @param senha
     *            Senha do usuário
     * @param turno
     *            Turno
     * @return
     * @throws IOException
     * @throws ParseException
     * @throws CPFExcedeuMaximoTentativas
     * @throws LoginFalhou
     */
    public Relogio apontarPonto(String cpf, String senha, Turno turno)
            throws IOException, ParseException, LoginFalhou {
        //final DefaultHttpClient httpclient = this.obterPonto();

        // TODO Auto-generated method stub
        return null;
    }

    public void abrirPaginaSiscop() {

        try {
            java.awt.Desktop.getDesktop().browse(new URI("http://siscop.portalcorporativo.serpro/"));
        } catch (Exception e) {
            log.error("Erro ao abrir Siscop", e);
        }

    }
}