package core.person.client.module.form;

import rnd.webapp.mwt.client.application.AbstractFormHelper;
import rnd.webapp.mwt.client.bean.ApplicationBean;
import rnd.webapp.mwt.client.bean.BeanPropertyList;
import rnd.webapp.mwt.client.bean.BindingManager;
import rnd.webapp.mwt.client.constant.sql.Types;
import rnd.webapp.mwt.client.data.impl.ColumnMetaDataImpl;
import rnd.webapp.mwt.client.expression.BeanPropertyExpression;
import rnd.webapp.mwt.client.expression.BinaryExpression;
import rnd.webapp.mwt.client.expression.BinaryOperation;
import rnd.webapp.mwt.client.expression.Expression;
import rnd.webapp.mwt.client.expression.LiteralExpression;
import rnd.webapp.mwt.client.mvc.MVCHandlerFactory;
import rnd.webapp.mwt.client.mvc.field.Table;
import rnd.webapp.mwt.client.mvc.field.Table.BeanTableModel.RowDelegate;
import rnd.webapp.mwt.client.mvc.field.data.text.TextField;
import rnd.webapp.mwt.client.mvc.page.form.Form;
import core.person.client.Person;

public class PersonFormHelper extends AbstractFormHelper {

	public String getFormName() {
		return "Person";
	}

	public String getViewName() {
		return "Person";
	}

	public Form createForm() {

		Form form = MVCHandlerFactory.getMVCHandler().createForm();

		// MVC

		// Label firstNameLabel = MVCHandlerFactory.getMVCHandler().createLabel("First Name");
		// form.add(firstNameLabel);

		TextField firstName_TextBox = MVCHandlerFactory.getMVCHandler().createTextField("First Name");
		firstName_TextBox.setName("firstName");
		form.addField(firstName_TextBox);

		// Label lastName_Label = MVCHandlerFactory.getMVCHandler().createLabel("Last Name");
		// form.add(lastName_Label);

		TextField lastName_TextBox = MVCHandlerFactory.getMVCHandler().createTextField("Last Name");
		lastName_TextBox.setName("lastName");
		form.addField(lastName_TextBox);

		// Label fullName_Label = MVCHandlerFactory.getMVCHandler().createLabel("Full Name");
		// form.add(fullName_Label);

		TextField fullName_TextBox = MVCHandlerFactory.getMVCHandler().createTextField("Full Name");
		fullName_TextBox.setName("fullName");
		form.addField(fullName_TextBox);

		ColumnMetaDataImpl[] columnMetaDatas = new ColumnMetaDataImpl[3];

		columnMetaDatas[0] = new ColumnMetaDataImpl();
		columnMetaDatas[0].setType(Types.VARCHAR);
		columnMetaDatas[0].setUpdatable(true);
		columnMetaDatas[0].setDisplayName("First Name");
		columnMetaDatas[0].setName("firstName");
		columnMetaDatas[0].setDisplayWidth(150);
		columnMetaDatas[0].setExpression(new BeanPropertyExpression("firstName"));

		columnMetaDatas[1] = new ColumnMetaDataImpl();
		columnMetaDatas[1].setType(Types.VARCHAR);
		columnMetaDatas[1].setUpdatable(true);
		columnMetaDatas[1].setDisplayName("Last Name");
		columnMetaDatas[1].setName("lastName");
		columnMetaDatas[1].setDisplayWidth(150);
		columnMetaDatas[1].setExpression(new BeanPropertyExpression("lastName"));

		columnMetaDatas[2] = new ColumnMetaDataImpl();
		columnMetaDatas[2].setType(Types.VARCHAR);
		columnMetaDatas[2].setUpdatable(false);
		columnMetaDatas[2].setDisplayName("Full Name");
		columnMetaDatas[2].setName("fullName");
		columnMetaDatas[2].setDisplayWidth(150);
		columnMetaDatas[2].setExpression(new BeanPropertyExpression("fullName"));

		RowDelegate rowDelegate = new RowDelegate() {

			public Object addRow() {

				Person person = new Person();
				
				// Full Name Binding

				Expression firstNameExp = new BeanPropertyExpression("firstName");
				Expression lastNameExp = new BeanPropertyExpression("lastName");
				Expression literalExp = new LiteralExpression(" ");

				Expression firstBinExp = new BinaryExpression(firstNameExp, literalExp, BinaryOperation.ADD);
				Expression fullNameBinExp = new BinaryExpression(firstBinExp, lastNameExp, BinaryOperation.ADD);

				Expression fullNameExp = new BeanPropertyExpression("fullName");

				BindingManager.bindExpression(person, fullNameBinExp, person, fullNameExp);

				return person;
			}

		};

		Table childrenTable = MVCHandlerFactory.getMVCHandler().createTable(Table.BEAN_BASED);
		childrenTable.setColumnMetaData(columnMetaDatas);
		
		((Table.BeanTableModel) childrenTable.getModel()).setRowDelegate(rowDelegate);

		form.addField(childrenTable);

		// Bean

		Person person = new Person();

		// Full Name Binding

		Expression firstNameExp = new BeanPropertyExpression("firstName");
		Expression lastNameExp = new BeanPropertyExpression("lastName");
		Expression literalExp = new LiteralExpression(" ");

		Expression firstBinExp = new BinaryExpression(firstNameExp, literalExp, BinaryOperation.ADD);
		Expression fullNameBinExp = new BinaryExpression(firstBinExp, lastNameExp, BinaryOperation.ADD);

		Expression fullNameExp = new BeanPropertyExpression("fullName");

		BindingManager.bindExpression(person, fullNameBinExp, person, fullNameExp);

		((Table.BeanTableModel) childrenTable.getModel()).setDataList(new BeanPropertyList(person, "children", "father"));

		return form;
	}

	public ApplicationBean createApplicationBean() {
		return new Person();
	}

}