package com.ashtonhogan.tacinga.conditions;

import com.ashtonhogan.tacinga.Condition;
import com.ashtonhogan.tacinga.text.ActualText;
import com.ashtonhogan.tacinga.text.ExpectedText;
import com.ashtonhogan.tacinga.text.PrefixText;
import com.ashtonhogan.tacinga.unit.ObjectUnit;

@SuppressWarnings({"FinalClass", "ClassWithoutLogger"})
public final class EqualCondition implements Condition {

    private final PrefixText prefixText;
    private final ObjectUnit expected;
    private final ObjectUnit actual;

    public EqualCondition(final ObjectUnit expected, final ObjectUnit actual) {
        this(
                new PrefixText(""),
                expected,
                actual
        );
    }

    public EqualCondition(final PrefixText prefixText, final ObjectUnit expected, final ObjectUnit actual) {
        this.prefixText = prefixText;
        this.expected = expected;
        this.actual = actual;
    }

    @Override
    public ExpectedText expected() throws Exception {
        return new ExpectedText(this.prefixText, this.expected.asText());
    }

    @Override
    public ActualText actual() throws Exception {
        return new ActualText(this.prefixText, this.actual.asText());
    }

    @Override
    public Boolean conforms() throws Exception {
        if (this.actual.asValue() == null) {
            return this.expected.asValue() == null;
        }
        return this.actual.asValue().equals(this.expected.asValue());
    }

}