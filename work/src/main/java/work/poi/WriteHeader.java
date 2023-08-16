package work.poi;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gorilla
 * @date: 2023/8/15 14:15
 */
public class WriteHeader {
    public static void main(String[] args) throws Exception {
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

        // 添加页眉
        XWPFHeader header = doc.createHeader(HeaderFooterType.DEFAULT);
        XWPFParagraph headerParagraph = header.createParagraph();
        headerParagraph.getCTP().addNewFldSimple().setInstr("PAGE \\* MERGEFORMAT");
//        XWPFRun headerRun = headerParagraph.createRun();
//        headerRun.setText("这是页眉");
//        headerRun.setBold(true);
//        headerRun.setItalic(true);
        // 保存文档
        try (FileOutputStream out = new FileOutputStream("work/src/main/java/work/poi/test02.docx")) {
            doc.write(out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("文档已保存。");
    }

    public static void createHeader(XWPFDocument doc, String orgFullName) throws Exception {
        /*
         * 对页眉段落作处理
         * */
        CTSectPr sectPr = doc.getDocument().getBody().addNewSectPr();
        XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(doc,sectPr);
        XWPFHeader header = headerFooterPolicy.createHeader(XWPFHeaderFooterPolicy.DEFAULT);
        XWPFParagraph paragraph = header.getParagraphArray(0);
        paragraph.setBorderBottom(Borders.THICK);

        /*
         * 添加字体页眉，公司全称
         * */
        if (StringUtils.isNotEmpty(orgFullName)) {
            XWPFRun run = paragraph.createRun();
            run.setText(orgFullName);
            //setXWPFRunStyle(run,"新宋体",10);
        }
    }
}

