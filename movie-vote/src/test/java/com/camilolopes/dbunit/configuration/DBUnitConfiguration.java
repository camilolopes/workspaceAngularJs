package com.camilolopes.dbunit.configuration;

import java.io.FileInputStream;
import java.sql.Connection;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations={"classpath:/META-INF/spring/PersistentConfigurationTests-context.xml"})
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager")
@Transactional
public abstract class DBUnitConfiguration extends DatabaseTestCase {
	private FileInputStream loadFile;	
	private Connection connection;
	@Autowired
	private SessionFactory sessionFactory;
	private  final String pathDataSet = "src/test/resources/";
	private  String nameDataSetXml = "movie-dataset.xml";
	private  String dataSetXml;

	public DBUnitConfiguration() {
		super();
	}

	public DBUnitConfiguration(String name) {
		super(name);
	}
	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		connection = SessionFactoryUtils.getDataSource(sessionFactory).getConnection();
		IDatabaseConnection iDataBaseConnection = new DatabaseConnection(connection);
		return iDataBaseConnection ;
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		 dataSetXml = pathDataSet + getNameDataSetXml(); 
		loadFile = new FileInputStream(dataSetXml);
		IDataSet dataSet = new FlatXmlDataSetBuilder().build(loadFile);
		return dataSet;
	}
	@Override
	protected DatabaseOperation getSetUpOperation() throws Exception {

		return DatabaseOperation.CLEAN_INSERT;
	}

	public String getNameDataSetXml() {
		return nameDataSetXml;
	}

	public void setNameDataSetXml(String nameDataSetXml) {
		this.nameDataSetXml = nameDataSetXml;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


}
