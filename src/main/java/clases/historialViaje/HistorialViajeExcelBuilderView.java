package clases.historialViaje;

import clases.configuration.Parametros;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hpsf.PropertySetFactory;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import clases.dominio.Viaje;

@SuppressWarnings("deprecation")
public class HistorialViajeExcelBuilderView extends AbstractExcelView {

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HSSFCellStyle my_style = workbook.createCellStyle();

		HSSFFont my_font = workbook.createFont();
		my_font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		my_style.setFont(my_font);

		String topeExcelString = Parametros.HISTORIALVIAJE_EXCEL_TOPE;
		double topeExcel = Integer.parseInt(topeExcelString);

		@SuppressWarnings("unchecked")
		List<Viaje> viajesAExportar = (List<Viaje>) model.get("export_audit");

		String tipoArchivo = (String) model.get("tipo_archivo");
		double tempCantSheets = Math.ceil(viajesAExportar.size() / topeExcel);  // Redondeo para arriba
		int cantSheets = (int) tempCantSheets;

		// Creo las sheets
		for (int i = 1; i <= cantSheets; i++) {

			String tituloSheet = "Listado de Auditor�a";

			//Create a blank sheet
			HSSFSheet sheet;
			if (i == 1) {
				sheet = workbook.createSheet(tituloSheet);
			} else {
				tituloSheet = tituloSheet + " " + i;
				sheet = workbook.createSheet(tituloSheet + " " + i);
			}
			sheet.setColumnWidth(0, 10000);
//			sheet.setColumnWidth(1, 20000);
//			sheet.setColumnWidth(2, 10000);
			workbook.setSheetName(i - 1, tituloSheet);

			// Set column titles
			HSSFRow row0 = sheet.createRow(0);
			HSSFCell cell_row1 = row0.createCell(0);
//			HSSFCell cell_row2 = row0.createCell(1);
//			HSSFCell cell_row3 = row0.createCell(2);
			cell_row1.setCellValue("Id");
//			cell_row2.setCellValue("Acci�n");
//			cell_row3.setCellValue("Fecha y hora");
			cell_row1.setCellStyle(my_style);
//			cell_row2.setCellStyle(my_style);
//			cell_row3.setCellStyle(my_style);

			List<Viaje> viajes = new ArrayList();

			// Si hay m�s registros de los permitidos por Excel voy agregando de a 10000 por sheet
			if (viajes.size() > topeExcel) {
				viajes = viajesAExportar.subList(0, (int) topeExcel - 1);
			} else {
				viajes = viajesAExportar;
			}

			int rowNum = 1;
			for (Viaje v : viajes) {
				HSSFRow row1 = sheet.createRow(rowNum);
				cell_row1 = row1.createCell(0);
//				cell_row2 = row1.createCell(1);
//				cell_row3 = row1.createCell(2);

				cell_row1.setCellValue(v.getId());

//				cell_row2.setCellValue(audit.getAccion());
//				cell_row3.setCellValue(DATE_FORMAT.format(audit.getFechahora()));

				rowNum++;
			}

			// Elimino las marcas que ya se agregaron al excel
			viajesAExportar.removeAll(viajes);
		}
	}
}
