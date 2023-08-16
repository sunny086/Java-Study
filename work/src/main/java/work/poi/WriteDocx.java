package work.poi;

import org.apache.poi.xwpf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gorilla
 * @date: 2023/8/15 15:05
 */
public class WriteDocx {
    public static void main(String[] args) {
        XWPFDocument doc = new XWPFDocument();

        int totalIndex = 5;

        for (int pageIndex = 0; pageIndex < totalIndex; pageIndex++) {
            // 添加标题
            XWPFParagraph titlePara = doc.createParagraph();
            titlePara.setAlignment(ParagraphAlignment.CENTER);

            XWPFRun titleRun = titlePara.createRun();
            titleRun.setBold(true);
            titleRun.setFontSize(20);
            titleRun.setText("这是标题");

            // 添加段落
            XWPFParagraph paragraph = doc.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText("这是一个段落，用于演示创建 Word 文档。");

            if (pageIndex < totalIndex - 1) {
                XWPFParagraph pageBreakPara = doc.createParagraph();
                XWPFRun pageBreakRun = pageBreakPara.createRun();
                pageBreakRun.setFontSize(0);
                pageBreakRun.addBreak(BreakType.PAGE);
            }
        }
        // 保存文档
        try (FileOutputStream out = new FileOutputStream("work/src/main/java/work/poi/test01.docx")) {
            doc.write(out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("文档已保存。");
    }
}
