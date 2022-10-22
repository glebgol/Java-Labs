package Platforms;

import Actions.AndroidVersion12Action;
import Interfaces.IAction;
import Interfaces.IOptions;
import Interfaces.IPlatform;
import Interfaces.ISuperAction;
import Options.AndroidVersion12Options;
import SuperActions.AndroidVersion12SuperAction;


public class AndroidVersion12 implements IPlatform {

    @Override
    public IAction Action() {
        return new AndroidVersion12Action();
    }

    @Override
    public IOptions Options() {
        return new AndroidVersion12Options();
    }

    @Override
    public ISuperAction SuperAction() {
        return new AndroidVersion12SuperAction();
    }
}
