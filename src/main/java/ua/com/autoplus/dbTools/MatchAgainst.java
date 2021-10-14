package ua.com.autoplus.dbTools;

import org.hibernate.QueryException;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.type.BooleanType;
import org.hibernate.type.Type;

import java.util.List;

public class MatchAgainst implements SQLFunction {

    @Override
    public String render(Type type, List args, SessionFactoryImplementor factory) throws QueryException {

        StringBuffer buf = new StringBuffer();

        buf.append("MATCH(");

        for ( int i=0; i<args.size()-1; i++) {
            buf.append(args.get(i));
            if (i<args.size()-2) buf.append(",");
        }
        buf.append(")");

        buf.append(" AGAINST(");
        buf.append(args.get(args.size()-1));
        buf.append(" IN BOOLEAN MODE)");

        return buf.toString();
    }

    @Override
    public boolean hasArguments() {
        return true;
    }

    @Override
    public boolean hasParenthesesIfNoArguments() {
        return false;
    }

    @Override
    public Type getReturnType(Type type, Mapping mapping) throws QueryException {
        return new BooleanType();
    }

}
