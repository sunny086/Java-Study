package work.poi;

import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gorilla
 * @date: 2023/8/16 12:21
 */
public class WriteDocTest {

    @Test
    public void testWriteDoc() {
        XWPFDocument doc = new XWPFDocument();
        XWPFHeader header = doc.createHeader(HeaderFooterType.DEFAULT);
        XWPFParagraph headerParagraph = header.createParagraph();
        headerParagraph.getCTP().addNewFldSimple().setInstr("PAGE \\* MERGEFORMAT");


        try (FileOutputStream out = new FileOutputStream("./test02.docx")) {
            doc.write(out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
