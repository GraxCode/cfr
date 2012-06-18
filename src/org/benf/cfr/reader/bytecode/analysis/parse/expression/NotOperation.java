package org.benf.cfr.reader.bytecode.analysis.parse.expression;

import org.benf.cfr.reader.bytecode.analysis.parse.Expression;
import org.benf.cfr.reader.bytecode.analysis.parse.utils.LValueCollector;
import org.benf.cfr.reader.bytecode.analysis.parse.utils.SSAIdentifiers;

/**
 * Created by IntelliJ IDEA.
 * User: lee
 * Date: 22/03/2012
 * Time: 06:45
 * To change this template use File | Settings | File Templates.
 */
public class NotOperation implements ConditionalExpression {
    private ConditionalExpression inner;

    public NotOperation(ConditionalExpression lhs) {
        this.inner = lhs;
    }

    @Override
    public int getSize() {
        return 1 + inner.getSize();
    }

    @Override
    public Expression replaceSingleUsageLValues(LValueCollector lValueCollector, SSAIdentifiers ssaIdentifiers) {
        return this;
    }

    @Override
    public boolean isSimple() {
        return false;
    }

    @Override
    public String toString() {
        return "!(" + inner.toString() + ")";
    }

    @Override
    public ConditionalExpression getNegated() {
        return inner;
    }

    @Override
    public ConditionalExpression getDemorganApplied(boolean amNegating) {
        return inner.getDemorganApplied(!amNegating);
    }
}
