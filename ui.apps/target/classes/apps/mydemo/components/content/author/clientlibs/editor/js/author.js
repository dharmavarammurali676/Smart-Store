/* global jQuery, Coral */
(function($, Coral) {
    "use strict";

    console.log(" --------CLIENTLIBS LOADED------- ");

    var registry = $(window).adaptTo("foundation-registry");
 ///////////// FIRSTNAME Validation
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=mydemo-firstname-validation]",
        validate: function(element) {
            let el = $(element);
            let pattern=/[0-9]/;
            let value=el.val();
            if(pattern.test(value)){
               return "add only UPPER Case Letters";
            }

        }
    });
 ///////////// LASTNAME Validation
    registry.register("foundation.validation.validator", {
            selector: "[data-validation=mydemo-lastname-validation]",
            validate: function(element) {
                let el = $(element);
                let pattern=/[0-9]/;
                let value=el.val();
                if(pattern.test(value)){
                   return "add only LOWER Case Letters";
                }

            }
        });

    ///////////// EMAIL Validation
    registry.register("foundation.validation.validator", {
                selector: "[data-validation=mydemo-email-validation]",
                validate: function validateEmail(email) {
                            var mailFormat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
                            if (email.value.match(mailFormat)) {
                              return "Sorry, this email is Invalid 😩!";
                            }
                          }
            });
(function () {
    "use strict";

    var dialog = $(window).adaptTo("foundation-ui").prompt("getDialog");
    var dropdownField = dialog.getField("./dropdown");
    var textField = dialog.getField("./text");

    dropdownField.on("selectionchanged", function (selectedOption) {
        if (selectedOption) {
            textField.setValue(selectedOption.value);
        }
    });
}());

})(jQuery, Coral);
