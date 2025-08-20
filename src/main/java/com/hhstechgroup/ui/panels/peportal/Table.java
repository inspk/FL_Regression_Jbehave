package com.hhstechgroup.ui.panels.peportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.KeyValueMapper;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Table extends AbstractPanel implements KeyValueMapper{

    private static final String TABLE_COLUMNS = ".//th";
    private static final String TABLE_ROWS = ".//tr[td]";
    private static final String TABLE_CELL = "td";
    private String columns;
    private String rows;
    private String cell;
    private WebElementFacade row;


    public Table(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        this(panelBaseLocation, basePage, TABLE_COLUMNS, TABLE_ROWS, TABLE_CELL);
    }

    public Table(WebElementFacade panelBaseLocation, AbstractPage basePage, String columns, String rows, String cell) {
        super(panelBaseLocation, basePage);
        this.columns = columns;
        this.rows = rows;
        this.cell = cell;
    }

    public List<Map<String, String>> getListOfMappedValues() {
        return findAll(this.rows).stream().map(row -> {
            this.row = row;
            return getMappedValues();
        }).collect(toList());
    }

    public Map<String, String> getMappedValues() {
        return findAll(columns).stream().collect(Collectors.toMap(WebElementFacade::getText, el -> row.thenFindAll(cell).get(getPositionRelatedToSibling(el) - 1).getAttribute("innerText").replaceAll("\\n"," ").trim()));
    }
}