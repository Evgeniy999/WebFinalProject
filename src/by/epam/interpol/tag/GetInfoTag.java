package by.epam.interpol.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class GetInfoTag extends TagSupport
{
    public int doStartTag() throws JspException
    {
        String str = "By Evgeniy Schipunov, 2018 | Epam";
        try
        {
            JspWriter out = pageContext.getOut();
            out.write(str);
        }
        catch (IOException e)
        {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }

}

