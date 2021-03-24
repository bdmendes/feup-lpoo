package string;

import java.util.List;

public class StringTransformerGroup implements StringTransformer {

    List<StringTransformer> transformers;

    public StringTransformerGroup(List<StringTransformer> transformers){
        this.transformers = transformers;
    }

    @Override
    public void execute(StringDrink drink) {
        for (StringTransformer t : transformers) {
            t.execute(drink);
        }
    }

    @Override
    public void undo(StringDrink drink) {
        for (int i = transformers.size() - 1; i >= 0; i--) {
            transformers.get(i).execute(drink);
        }
    }
}
