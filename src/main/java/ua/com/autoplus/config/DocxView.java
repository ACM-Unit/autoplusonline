package ua.com.autoplus.config;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.web.servlet.view.AbstractView;
import ua.com.autoplus.entity.Warehouse;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class DocxView extends AbstractView {
        public DocxView () {
            this.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        }

        protected boolean generatesDownloadContent() {
            return true;
        }

        protected final void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("gghghghg111");
            XWPFDocument document = this.createDocument(model, request);
            this.buildExcelDocument(model, document, request, response);
            response.setContentType(this.getContentType());
            this.renderDocument(document, response);
        }

        protected XWPFDocument createDocument(Map<String, Object> model, HttpServletRequest request) throws URISyntaxException, InvalidFormatException, IOException {
            File template = new File(getClass().getClassLoader().getResource("pattern.docx").toURI());
            return new XWPFDocument(OPCPackage.open(template));
        }

        protected void renderDocument(XWPFDocument workbook, HttpServletResponse response) throws IOException {
            ServletOutputStream out = response.getOutputStream();
            workbook.write(out);
            workbook.close();
        }

        protected void buildExcelDocument(Map<String, Object> model, XWPFDocument document, HttpServletRequest req, HttpServletResponse resp) throws Exception {
            resp.setHeader("Content-Disposition", "attachment; filename=\"users.docx\"");
            System.out.println("gghghghg");
            for (XWPFParagraph paragraph : document.getParagraphs()) {
                Warehouse warehouse = (Warehouse) model.get("warehouse");
                for (XWPFRun run : paragraph.getRuns()) {
                    String text = run.getText(0);
                    text = text.replace("name", warehouse.getName());
                    text = text.replace("slug", warehouse.getAddress());
                    text = text.replace("code", String.valueOf(warehouse.getId()));
                    run.setText(text, 0);
                }
            }
        }
    }


