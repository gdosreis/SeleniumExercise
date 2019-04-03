package readers;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader 
{
	private final String propertyFilePath= "resources//testParameters.properties";
    private String ebayBaseuRL;
    private String gmailBaseuRL;
    private String user;
    private String pass;
    private String searchValue;
 
    /**  
	 * @description:Get all configuration data and assign to related fields.
	 */
    public ConfigFileReader() 
    {
        //Declare a properties object
        Properties prop = new Properties();
 
        //Read configuration.properties file
        try {
            prop.load(new FileInputStream(propertyFilePath));
            //prop.load(this.getClass().getClassLoader().getResourceAsStream("configuration.properties"));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
 
        //Get properties from configuration.properties
        ebayBaseuRL = prop.getProperty("ebayBaseuRL");
        gmailBaseuRL = prop.getProperty("gmailBaseuRL");
        user = prop.getProperty("user");
        pass = prop.getProperty("pass");
        searchValue = prop.getProperty("searchValue");
    }
 
    /**  
	 * @description: return ebayBaseuRL value.
	 */
    public String getEbayBaseURL() 
    {
      return ebayBaseuRL;
    }
    
    /**  
	 * @description: return gmailBaseuRL value.
	 */
    public String getGmailBaseURL() 
    {
        return gmailBaseuRL;
    }
 
    /**  
	 * @description: return user value.
	 */
    public String getUser() 
    {
        return user;
    }
 
    /**  
	 * @description: return pass value.
	 */
    public String getPassword() 
    {
        return pass;
    }
    
    /**  
	 * @description: return searchValue value.
	 */
    public String getSearchValue() 
    {
        return searchValue;
    }
}
