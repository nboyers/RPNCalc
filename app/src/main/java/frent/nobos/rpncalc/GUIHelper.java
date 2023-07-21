package frent.nobos.rpncalc;




public class GUIHelper {
    private final StringBuilder display;             // the string that is returned for the user to see
    private boolean       isEditable;          // current num can be changed (<, ., more digits)
    private boolean       displayIsInStack;    // displayed number is saved in the stack
    private final RPNCalcMath calc;                // MVC controller object

    /**
     * no-arg constructor. initialize display attributes
     */
    public GUIHelper() {
        calc = new RPNCalcMath();
        display = new StringBuilder();
        setDisplay("");
        displayIsInStack = false;
        isEditable = false;
    }

    /**
     * do all the work
     * @param key a key pressed by the user: 0-9,+/-,<
     * @return the current number as a string
     */
    public String addKey(String key) {
        double  num;                   // the double version of the current number
        boolean tauClicked = false;   // little helper to handle pi and tau

        switch (key.toLowerCase()) {
            case "+":
                finishCurrentNum();
                setDisplay("" + calc.add());
                break;

            case "-":
                finishCurrentNum();
                setDisplay("" + calc.subtract());
                break;

            case "*":
                finishCurrentNum();
                setDisplay("" + calc.multiply());
                break;

            case "/":
                finishCurrentNum();
                setDisplay("" + calc.divide());
                break;

            case "^":     // "enter" key
                num = getNum();
                calc.enterNumber(num);
                setDisplay("" + num);
                displayIsInStack = true;
                isEditable = false;
                break;

            case "+/-":    // change sign
                num = getNum();
                if (num != 0.0) {
                    if (display.charAt(0) == '-') {
                        display.deleteCharAt(0);
                    }
                    else {
                        display.insert(0, '-');
                    }
                    displayIsInStack = false;
                }
                break;

            case "<":
                if (isEditable && display.length() > 0) {
                    display.deleteCharAt(display.length() - 1);
                    if (display.length() == 0) {
                        setDisplay("0");
                    }
                }
                break;

            case "tau":
            case "τ":
                tauClicked = true;
                // fall into pi case(s)
            case "pi":
            case "π":
                // if a number has been partially entered by the user, finish it
                finishCurrentNum();
                // enter π or τ
                num = Math.PI * ((tauClicked) ? 2 : 1);
                calc.enterNumber(num);
                setDisplay("" + num);
                break;

            case ".":  // only one . in a number!
                if (displayIsInStack) {
                    setDisplay("0.");
                    displayIsInStack = false;
                    isEditable = true;
                    break;
                }
                else if (isEditable && !display.toString().contains(".")) {
                    display.append(key);
                }
                break;

            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                if (isEditable) {
                    display.append(key);
                }
                else {
                    if (!displayIsInStack) {
                        calc.enterNumber(getNum());
                    }
                    setDisplay(key);//new StringBuilder(key);
                }
                displayIsInStack = false;
                isEditable = true;
                break;
        }

        return display.toString();
    }

    /**
     * set/reset the string to be displayed
     * @param init the string to be displayed
     */
    private void setDisplay(String init) {
        init = (init == null) ? "" : init;
        display.replace(0, display.length(), init);
    }

    /**
     * some code common to all the operator keys in addKey
     */
    private void finishCurrentNum() {
        if (isEditable){
            calc.enterNumber(getNum());
        }

        // this will be true after the operation is done
        // and the result of the operation is in display
        displayIsInStack = true;

        isEditable = false;          // can't change the result of operation, only overwrite it
    }

    /**
     * get the number in the display string, or zero (0.0) if it's not a number
     * @return number from the display string
     */
    private double getNum() {
        double num = 0.0;             // number to get from display

        try {
            num = Double.parseDouble(display.toString());
        }
        catch (NumberFormatException e) {
            // if it's not a number, just return the default (0.0)
        }

        return num;
    }
}




