/* global jQuery, Coral */
(function($, Coral) {
    "use strict";

    console.log(" --------CLIENTLIBS LOADED------- ");

    var registry = $(window).adaptTo("foundation-registry");
 ///////////// FIRSTNAME Validation
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=mydemo-titlename-validation]",
        validate: function(element) {
            let el = $(element);
            let pattern=/[0-9]/;
            let value=el.val();
            if(pattern.test(value)){
               return "add only UPPER Case Letters";
            }

        }
    });
})(jQuery, Coral);




//
//(function () {
//    "use strict";
//
//    var dialog = $(window).adaptTo("foundation-ui").prompt("getDialog");
//    var textFieldValue = dialog.getField("./text").getValue();
//    var dropdownOptions = [
//        {
//            text: "-- Select --",
//            value: ""
//        },
//        {
//            text: textFieldValue,
//            value: textFieldValue
//        }
//    ];
//    dialog.getField("./dropdown").setOptions(dropdownOptions);
//}());
//
/////////////// LASTNAME Validation
//    registry.register("foundation.validation.validator", {
//            selector: "[data-validation=mydemo-title-validation]",
//            validate: function(element) {
//                let el = $(element);
//                let pattern=/[0-9]/;
//                let value=el.val();
//                if(pattern.test(value)){
//                   return "add only LOWER Case Letters";
//                }
//
//            }
//        });
//
//






















///* global jQuery, Coral */
//(function($, Coral) {
//    "use strict";
//
//    console.log(" --------CLIENTLIBS LOADED------- ");
//
//    var registry = $(window).adaptTo("foundation-registry");
// ///////////// FIRSTNAME Validation
//    registry.register("foundation.validation.validator", {
//        selector: "[data-validation=mydemo-name-validation]",
//        validate: function(element) {
//            let el = $(element);
//            let pattern=/[0-9]/;
//            let value=el.val();
//            if(pattern.test(value)){
//               return "add only UPPER Case Letters";
//            }
//
//        }
//    });
//
//})(jQuery, Coral);
