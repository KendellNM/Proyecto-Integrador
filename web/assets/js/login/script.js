
$(document).ready(function () {
    $("#contrasena")
            .focusin(function () {
                $("#contrasena_label").addClass(
                        "cursor-text text-xs -top-4 text-blue-600 transition-all"
                        );
            })
            .focusout(function () {
                if ($(this).val() === "") {
                    $("#contrasena_label").removeClass(
                            "cursor-text text-xs -top-4 text-blue-600 transition-all"
                            );
                }
            })
            .on("input", function () {
                if ($(this).val() !== "") {
                    $("#contrasena_label").addClass(
                            "cursor-text text-xs -top-4 text-blue-600 transition-all"
                            );
                } else {
                    $("#contrasena_label").removeClass(
                            "cursor-text text-xs -top-4 text-blue-600 transition-all"
                            );
                }
            });
});

$(document).ready(function () {
    $("#usuario")
            .focusin(function () {
                $("#usuario_label").addClass(
                        "cursor-text text-xs -top-4 text-blue-600 transition-all"
                        );
            })
            .focusout(function () {
                if ($(this).val() === "") {
                    $("#usuario_label").removeClass(
                            "cursor-text text-xs -top-4 text-blue-600 transition-all"
                            );
                }
            })
            .on("input", function () {
                if ($(this).val() !== "") {
                    $("#usuario_label").addClass(
                            "cursor-text text-xs -top-4 text-blue-600 transition-all"
                            );
                } else {
                    $("#usuario_label").removeClass(
                            "cursor-text text-xs -top-4 text-blue-600 transition-all"
                            );
                }
            });
});

$(document).ready(function () {
    $("#usuario").keydown(function (event) {
        if (event.key === "Enter") {
            $("#contrasena").focus();
        } else if (event.key === "ArrowDown") {
            $("#contrasena").focus();
        } else if (event.key === "ArrowUp") {
            $("#usuario").focus();
        }
    });

    $("#contrasena").keydown(function (event) {
        if (event.key === "Enter") {
            alert("hoola");
        } else if (event.key === "ArrowUp") {
            $("#usuario").focus();
        }
    });
});

function ver_contra() {
    let contrasena = $("#contrasena");
    var estado = contrasena.attr("type");

    if (estado === "password") {
        contrasena.attr("type", "text");
        $("#ver_contrasena").toggleClass("fa-eye fa-eye-slash");
    } else {
        contrasena.attr("type", "password");
        $("#ver_contrasena").toggleClass("fa-eye-slash fa-eye");
    }
}
