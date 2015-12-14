package com.minhafazenda.util;

import java.text.*;
import java.util.Date;
import java.util.Locale;
import javax.swing.*;
import javax.swing.text.*;

public class Formatacao
{

    static DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));

    public static JFormattedTextField getFormatado(String formato)
    {
        JFormattedTextField campoFormatado = null;
        MaskFormatter format = new MaskFormatter();

        format.setPlaceholderCharacter(' ');
        format.setValueContainsLiteralCharacters(false);

        try
        {
            format.setMask(formato);
            campoFormatado = new JFormattedTextField(format);
        } catch (ParseException ex)
        {
            ex.printStackTrace();
        }
        return campoFormatado;
    }

    public static void formatarDecimal(JTextField campo)
    {
        campo.setText(df.format(Double.parseDouble(campo.getText())));
    }

    public static JFormattedTextField getTelefone()
    {
        return getFormatado("(##) ####-####");
    }

    public static JFormattedTextField getCNPJ()
    {
        return getFormatado("##.###.###/####-##");
    }

    public static JFormattedTextField getCPF()
    {
        return getFormatado("###.###.###-##");
    }

    public static JFormattedTextField getData()
    {
        return getFormatado("##/##/####");
    }

    public void formatoDecimal(JTextField campo)
    {
        campo.setText(df.format(Double.parseDouble(campo.getText())));
    }

    

    
    public static void reformatarData(JFormattedTextField campo)
    {
        try
        {
            MaskFormatter m = new MaskFormatter();
            m.setPlaceholderCharacter(' ');
            m.setMask("##/##/####");
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }

    public static void reformatarCpf(JFormattedTextField campo)
    {
        try
        {
            MaskFormatter m = new MaskFormatter();
            m.setPlaceholderCharacter(' ');
            m.setMask("###.###.###-##");
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }

    public static void reformatarCnpj(JFormattedTextField campo)
    {
        try
        {
            MaskFormatter m = new MaskFormatter();
            m.setPlaceholderCharacter(' ');
            m.setMask("##.###.###/####-##");
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }

    public static void reformatarTelefone(JFormattedTextField campo)
    {
        try
        {
            MaskFormatter m = new MaskFormatter();
            m.setPlaceholderCharacter(' ');
            m.setMask("(##)####-####");
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }

    public static String ajustaDataDMA(String data)
    {
        String dataFormatada = null;
        try
        {
            Date dataAMD = new SimpleDateFormat("yyyy-MM-dd").parse(data);
            dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataAMD);
        } catch (Exception e)
        {
            System.err.println(e);
        }
        return (dataFormatada);
    }

    public static String ajustaDataAMD(String data)
    {
        String dataFormatada = null;
        try
        {
            Date dataDMA = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            dataFormatada = new SimpleDateFormat("yyyy-MM-dd").format(dataDMA);
        } catch (Exception e)
        {
            System.err.println(e);
        }
        return (dataFormatada);
    }

    public static String removerFormatacao(String dado)
    {
        String retorno = "";
        for (int i = 0; i < dado.length(); i++)
        {
            if (dado.charAt(i) != '.' && dado.charAt(i) != '/' && dado.charAt(i) != '-')
            {
                retorno = retorno + dado.charAt(i);
            }
        }
        return (retorno);
    }

    public static String getDataAtual()
    {
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dataHoje = df.format(now);

        return dataHoje;
    }

    //Define cor do fundo nos campos obrigatórios. 
    public void campoObrigatorio(JTextField campo)
    {
        //campo.setBackground(Color.LIGHT_GRAY);
        campo.setBackground(new java.awt.Color(235, 230, 248));
    }

    /**
     * Converte uma String para um objeto Date. Caso a String seja vazia ou
     * nula, retorna null - para facilitar em casos onde formulários podem ter
     * campos de datas vazios.
     *
     * @param data String no formato dd/MM/yyyy a ser formatada
     * @return Date Objeto Date ou null caso receba uma String vazia ou nula
     * @throws Exception Caso a String esteja no formato errado
     */
    public static Date formataData(String data) throws Exception
    {
        System.out.println("Data recebida: " + data);
        if (data == null || data.equals(""))
        {
            return null;
        }

        Date date = null;
        try
        {
            DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
            date = (java.util.Date) formatter.parse(data);
        } catch (ParseException e)
        {
            throw e;
        }
        return date;
    }

    
}
