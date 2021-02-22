package it.etlabora.world.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import it.etlabora.world.dao.CountryDao;
import it.etlabora.world.model.Country;
import it.etlabora.world.util.DbConnectionUtils;

public class CountryDaoImpl implements CountryDao {

	@Override
	public List<Country> getCountryList() {
		List<Country> countries = new ArrayList<>();
		try {
			Connection connection = DbConnectionUtils.getConnection();

			// CRUD = CREATE, READ, UPDATE, DELETE
			PreparedStatement st = connection.prepareStatement("SELECT * FROM country");

			ResultSet resultSet = st.executeQuery();
			while (resultSet.next()) {
				Country c = new Country();
				c.setId(resultSet.getLong("idcountry"));
				c.setName(resultSet.getString("name"));
				c.setCode(resultSet.getString("code"));
				countries.add(c);
			}

			st.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return countries;
	}
}
