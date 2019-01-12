package by.epam.interpol.command.impl.admin;

import by.epam.interpol.command.PagePath;
import by.epam.interpol.entity.Document;
import by.epam.interpol.entity.Person;
import by.epam.interpol.exception.ServiceException;
import by.epam.interpol.service.DocService;
import by.epam.interpol.service.PersonService;
import by.epam.interpol.service.impl.DocServiceImpl;
import by.epam.interpol.service.impl.PersonServiceImpl;
import by.epam.interpol.util.PersonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.Router;

import javax.lang.model.element.Name;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.sql.Blob;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

public class ApproveApplicationCommand implements ActionCommand {

    private static Logger LOGGER = LogManager.getLogger(ApproveApplicationCommand.class);
    private static final String DOC_ID = "docId";
    private static final String NAME = "name";
    private static final String LAST_NAME = "last";
    private static final String BIRTH = "birthday";
    private static final String WEIGHT = "weight";
    private static final String HEIGHT = "height";
    private static final String HAIR = "hair";
    private static final String NATIONALITY = "nationality";
    private static final String SEX = "gender";
    private static final String CHARACTERISTICS = "characteristics";
    private static final String STATUS = "status";
    private static final String PHOTO = "photo";

    @Override
    public Router execute(HttpServletRequest request) {//todo утвердить заявку
        PersonServiceImpl personService = new PersonServiceImpl();
        DocServiceImpl docService = new DocServiceImpl();
        Router router = new Router();
        Date birth = null;
        String currentId = request.getParameter(DOC_ID);
        String currentName = request.getParameter(NAME);
        String currentLast = request.getParameter(LAST_NAME);
        String currentBirth = request.getParameter(BIRTH);
        String currentWeight = request.getParameter(WEIGHT);
        String currentHeight = request.getParameter(HEIGHT);
        String currentHair = request.getParameter(HAIR);
        String currentNationality = request.getParameter(NATIONALITY);
        String currentSex = request.getParameter(SEX);
        String currentCharacteristics = request.getParameter(CHARACTERISTICS);
        String currentStatus = request.getParameter(STATUS);
        Optional<Document> document = docService.searchById(Integer.parseInt(currentId));

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
        try {
            birth = new Date(formatter.parse(currentBirth).getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        int weight = Integer.parseInt(currentWeight);
        int height = Integer.parseInt(currentHeight);
        int status = Integer.parseInt(currentStatus);
        try {
            personService.addPerson(currentName, currentLast, birth, weight, height, currentHair, currentNationality,
                    currentSex, currentCharacteristics, status, document.get().getPhoto());
            router.setPagePath(PagePath.MAIN_PAGE.getJspPath());

        } catch (Exception | ServiceException e) {
            LOGGER.warn("Person exception", e);
            router.setPagePath(PagePath.DOCS_TABLE.getJspPath());
        }
        return router;
    }
}
