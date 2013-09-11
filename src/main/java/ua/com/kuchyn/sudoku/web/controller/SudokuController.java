package ua.com.kuchyn.sudoku.web.controller;

import ua.com.kuchyn.sudoku.model.Sudoku;
import ua.com.kuchyn.sudoku.service.SudokuService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    private SudokuService sudokuService;

    @GET
    @Path("/generate")
    @Produces(MediaType.APPLICATION_JSON)
    public Sudoku generateSudoku()
    {
        return sudokuService.generateSudoku();
    }

    @GET
    @Path("/{id}/addCell/{i}/{j}/{number}")
    public void addCellToSudoku(@PathParam("id") Integer id, @PathParam("i") Integer i,
                                @PathParam("j") Integer j, @PathParam("number") Integer number)
    {
        Sudoku sudoku = sudokuService.getSudokuById(id);
        sudoku.setValue(i, j, number);
    }

    @GET
    @Path("/{id}")
    public Sudoku getSudokuById(Integer id)
    {
        Sudoku sudoku = sudokuService.generateSudoku();
        sudoku.setId(id);
        return sudoku;
    }

}
