package com.nagy.derrick;

import java.util.List;

public class PresidentDAOXML implements PresidentDAO {

    private static final String FILE_NAME = "presidents.xml";
    private static List<President> presidents;

    @Override
    public void readInData() throws DataException {

    }

    private void saveToFile() throws DataException {

    }

    @Override
    public void verifyPresidentList() throws DataException {

    }

    @Override
    public void createPresidentRecord(President president) throws DataException {

    }

    @Override
    public President getPresidentByPresidentID(int presidentID) throws DataException {
        return null;
    }

    @Override
    public List<President> getAllPresidents() throws DataException {
        return null;
    }

    @Override
    public void updatePresident(President original, President updated) throws DataException {

    }

    @Override
    public void deletePresident(President president) throws DataException {

    }

    @Override
    public void deletePresident(int presidentID) throws DataException {

    }
}
