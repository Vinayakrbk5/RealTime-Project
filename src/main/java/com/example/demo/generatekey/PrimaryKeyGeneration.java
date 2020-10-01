package com.example.demo.generatekey;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.jboss.logging.Logger;

public class PrimaryKeyGeneration implements IdentifierGenerator{
	
	private static final Logger log=Logger.getLogger(PrimaryKeyGeneration.class); 

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		log.info("Invoked generate() from "+this.getClass().getSimpleName());
		String primaryKey=null;
		String prefix="Xworkz-";
		
		try(Connection con=session.connection();) 
		{
		String query="select count(*) from LPG_LOGIN";
		PreparedStatement preStmt=con.prepareStatement(query);
		ResultSet resultSet=preStmt.executeQuery();
			while(resultSet.next())
			{
			primaryKey=prefix+resultSet.getInt(1)+1;
			}
			log.info("Key is : "+primaryKey);
			
		}catch (Exception e) {
			log.error("Error in generate() in "+this.getClass().getSimpleName(),e);
		}
		return primaryKey;
	}

}
