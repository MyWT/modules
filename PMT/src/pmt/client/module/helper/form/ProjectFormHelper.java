//package pmt.client.module.helper.form;
//
//import pmt.client.Phase;
//import pmt.client.Project;
//import rnd.mywt.client.application.AbstractFormHelper;
//import rnd.mywt.client.bean.ApplicationBean;
//import rnd.mywt.client.data.impl.ColumnMetaDataImpl;
//import rnd.mywt.client.expression.BeanPropertyExpression;
//import rnd.mywt.client.mvc.field.Table;
//import rnd.mywt.client.mvc.field.Table.BeanTableModel;
//import rnd.mywt.client.mvc.field.Table.BeanTableModel.RowDelegate;
//import rnd.mywt.client.mvc.field.data.ReferenceField;
//import rnd.mywt.client.mvc.field.data.text.TextField;
//import rnd.mywt.client.mvc.page.form.Form;
//import rnd.mywt.client.sql.Types;
//
//public class ProjectFormHelper extends AbstractFormHelper {
//
//	public ApplicationBean createApplicationBean() {
//		return new Project();
//	}
//
//	public Form createForm() {
//
//		Form form = super.createForm();
//
//		TextField name_TextBox = createTextField("Project", "projectName");
//		form.addField(name_TextBox);
//
//		ColumnMetaDataImpl[] columnMetaDatas = new ColumnMetaDataImpl[1];
//
//		columnMetaDatas[0] = new ColumnMetaDataImpl();
//		columnMetaDatas[0].setType(Types.VARCHAR);
//		columnMetaDatas[0].setUpdatable(true);
//		columnMetaDatas[0].setDisplayName("Phase");
//		columnMetaDatas[0].setName("phaseName");
//		columnMetaDatas[0].setDisplayWidth(45);
//		columnMetaDatas[0].setExpression(new BeanPropertyExpression("phaseName"));
//
//		RowDelegate rowDelegate = new RowDelegate() {
//			public Object newRow() {
//				return new Phase();
//			}
//		};
//
//		Table phaseTable = createTable();
//		phaseTable.setColumnMetaDatas(columnMetaDatas);
//		((BeanTableModel) phaseTable.getModel()).setRowDelegate(rowDelegate);
//
//		phaseTable.setBoundTo("phases");
//		form.addField(phaseTable);
//
//		ReferenceField createdById_RF = createReferenceField("Created By", "createdById", "AA", "User", "User", "UserName");
//		form.addField(createdById_RF);
//
//		return form;
//	}
//
//	public String getFormName() {
//		return "Project";
//	}
//
//	public String getViewName() {
//		return "Project";
//	}
//
//}
