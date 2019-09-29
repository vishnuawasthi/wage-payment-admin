# wage-payment-admin

http://localhost:8091/client-config#

# API Testing reference 
https://www.guru99.com/api-testing.html

#Date Picker in jquery
https://www.javatpoint.com/jquery-ui-datepicker

@Bean
public DataSource driverManagerDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/WP_ADM");
		dataSource.setUsername("WP_USER");
		dataSource.setPassword("root");
		return dataSource;
}