package test;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class TestPdf {

	public static void main(String[] args) {
		try {
			/* ���Ѿ�������ֶ��Ժ��pdfģ�� */
			PdfReader reader = new PdfReader("c:/aaass.pdf");

			/* ��Ҫ���ɵ�Ŀ��PDF�ļ����� */
			PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(
					"c:/iText������.pdf"));

			PdfContentByte under = stamp.getUnderContent(1);

			/* ʹ���������� */
			// BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
			// BaseFont.NOT_EMBEDDED);
			BaseFont bf = BaseFont.createFont("/MSYHBD.TTF",
					BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			Font FontChinese = new Font(bf, 12, Font.NORMAL);

			/* ȡ������ģ���е������ֶ� */
			AcroFields form = stamp.getAcroFields();
			form.addSubstitutionFont(bf);

			/* Ϊ�ֶθ�ֵ,ע���ֶ����������ִ�Сд�� */
			form.setField("fill_1", "�����");
			form.setField("fill_2", "26");
			form.setField("fill_3", "�߶��ѧ");
			form.setField("email", "phx@x263.net");
			form.setField("fill_4", "��iText���������");
			// �����޸�ֵ
			// Set<String> keys = form.getFields().keySet();
			// for (String name : keys) {
			// if (name == null || name.length() <= 0){
			// continue;
			// }
			//
			// AcroFields.Item item = form.getFieldItem(name);
			// String value = form.getField(name);
			// form.setFieldProperty(name, "textfont", bf/*
			// BaseFont.createFont() */, null);
			// form.setField(name, value);// reset value
			// }

			stamp.setFormFlattening(true);
			/* ����Ҫ��������������ĵ��������ɵ� */
			stamp.close();
			reader.close();
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
	}

}
