import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import symboltable.Scope;
import symboltable.GlobalScope;
import symboltable.VariableSymbol;

/**
 * Created by john on 09/03/14.
 */
public class GlobalScopeTest {

    public Scope createScope() {
        return new GlobalScope();
    }


    @Test
    public void beAbleToStoreAndResolveVariable() {
        Scope scope = createScope();

        scope.define(new VariableSymbol("a", 1));
        VariableSymbol symbol = (VariableSymbol) scope.resolve("a");

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(symbol.getName()).isEqualTo("a");
        //softly.assertThat(symbol.getType()).isEqualTo(InfixLexer.INTTYPE);
        softly.assertThat(symbol).isInstanceOf(VariableSymbol.class);
        softly.assertThat(symbol.getCompiledVariableName()).isEqualTo("1_a");
        softly.assertAll();

        
    }
}
