package katas.chainResponsability;

public class DocProcessor {

    private ChainValidator validator;

    public int sendDocument(Doc entry) {
        try {
            if (validator != null)
                validator.validate(entry);
            return 200;
        } catch (ValidationException e) {
            return e.getCode();
        }
    }

    public void setValidators(ChainValidator... all) {
        if (all == null || all.length == 0) {
            return;
        }
        validator = all[0];
        for (int i = 0; i < all.length - 1; i++) {
            all[i].setNext(all[i + 1]);
        }

    }

}
