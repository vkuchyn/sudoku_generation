package ua.com.kuchyn.sudoku.application;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 9/11/13
 * Time: 12:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class SudokuApplication extends ResourceConfig
{
    public SudokuApplication()
    {
        register(new SudokuBinder());
        register(JacksonJaxbJsonProvider.class);
        packages(true, "ua.com.kuchyn.sudoku.service", "ua.com.kuchyn.sudoku.web.controller");
    }
}
