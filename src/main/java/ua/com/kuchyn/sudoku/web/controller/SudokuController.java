package ua.com.kuchyn.sudoku.web.controller;

import ua.com.kuchyn.sudoku.model.Sudoku;
import ua.com.kuchyn.sudoku.service.simple.SimpleSudokuService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 9/10/13
 * Time: 11:07 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/sudoku")
public class SudokuController
{

    @Inject
    private SimpleSudokuService sudokuService;

    @GET
    @Path("/generate")
    @Produces(MediaType.APPLICATION_JSON)
    public Sudoku generateSudoku()
    {
        return sudokuService.generateSudoku();
    }

    @GET
    @Path("/{id}")
    public Sudoku getSudokuById(Integer id)
    {
        return null;
    }

}
