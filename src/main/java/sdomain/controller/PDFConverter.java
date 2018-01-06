package sdomain.controller;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

/**
 * Created by don on 7/5/2017.
 */
public class PDFConverter {

    public static void main(String[] args) {

        new PDFConverter().start();
    }

    private void start() {
        try {
            String sourceDir = "C:/Users/don/Pictures/2017-01-09/Scan1.PDF"; // Pdf files are read from this folder
            String destinationDir = "C:/Users/don/Pictures/2017-01-09/"; // converted images from pdf document are saved here

            File sourceFile = new File(sourceDir);
            File destinationFile = new File(destinationDir);
            if (!destinationFile.exists()) {
                destinationFile.mkdir();
                System.out.println("Folder Created -> "+ destinationFile.getAbsolutePath());
            }
            if (sourceFile.exists()) {
                System.out.println("Images copied to Folder: "+ destinationFile.getName());
                PDDocument document = PDDocument.load(sourceDir);
                List<PDPage> list = document.getDocumentCatalog().getAllPages();
                System.out.println("Total files to be converted -> "+ list.size());

                String fileName = sourceFile.getName().replace(".pdf", "");
                int pageNumber = 1;
                for (PDPage page : list) {
                    BufferedImage image = page.convertToImage(1, 1024);
                    File outputfile = new File(destinationDir + fileName.replaceAll(".PDF","") + ".jpg");
                    System.out.println("Image Created -> "+ outputfile.getName());
                    ImageIO.write(image, "jpg", outputfile);
                    pageNumber++;
                }
                document.close();
                System.out.println("Converted Images are saved at -> "+ destinationFile.getAbsolutePath());
            } else {
                System.err.println(sourceFile.getName() +" File not exists");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
