$(document).ready(function () {
    alert("yeeah!");
    function createNewImageRow(lastImageIndex) {
        var currentImageIndex = lastImageIndex + 1
        var imageContent = "<div class='row' id='image-'" + currentImageIndex + "'>" +
        "<div class='form-group col-xs-12'>" +
        "<label class='label' for='item_image-" + currentImageIndex + "'>item image:</label>" +
        "<input type='file' value='' id='item_image-" + currentImageIndex + "'" +
        "class='form-control' name='medias[" + currentImageIndex + "].mediaRef'>" +
        "<input type='hidden' name='medias[" + currentImageIndex + "].type' value='image'/>" +
        "</div></div>"
    }

    $(document).on("click", "button#addMoreImage", function () {
        //var lastId = $("#images").last().attr('id');
        //if (lastId != "") {
        //    lastId = lastId.replace("image-", "")
        //}
        $("#alert").appendData("yeeah")
        alert("lastId: ")
    });

    /*$(document).on("click", "#next", function () {
        var pageNumber = $("#orders>tbody").attr('id').match(/page_(\d+)/)[1];
        $.ajax({
            url: 'orderPaginate',
            type: 'POST',
            data: {"pageNumber": parseInt(pageNumber) + 1},
            success: function (data) {
                disableIfLast(data);
                console.log(data);
                var rows = orderRowsFromData(data);
                $("#orders>tbody").remove();
                var id = "page_" + data.pageNumber;
                $("#orders").append("<tbody id=" + id + ">" + rows + "</tbody>");
            }
        })
    });

    function disableIfLast(data) {
        if (data.last == true) {
            $("#next").addClass("disabled");
        } else
            $("#next").removeClass("disabled");
        if (data.pageNumber == 0)
            $("#prev").addClass("disabled");
        else
            $("#prev").removeClass("disabled");
    }

    function orderRowsFromData(data) {
        var rows = "";
        var items = data.items;
        for (var i in items) {
            var row = "<tr id='" + items[i].id + "'>" +
                "<td>" + items[i]["id"] + "</td>" +
                "<td>" + items[i].client.firstName + "</td>" +
                "<td>" + items[i].pickupLocation + "</td>" +
                "<td>" + items[i].dropOffLocation + "</td>" +
                "<td>" + items[i].carClass + "</td>" +
                "<td>" + items[i].receivedTime + "</td>" +
                "<td><button id='removeOrder' value='" + items[i].id + "' class='btn-danger' type='button'>remove" +
                "</button></td>"
                + "</tr>";
            rows += row;
        }
        return rows;
    }

    $(document).on("click", "#removeOrder", function () {
        var orderId = $(this).attr("value");
        console.log(orderId);
        $.ajax({
            url: 'removeOrder',
            type: 'POST',
            data: {"orderId": orderId},
            success: function (data) {
                console.log(data);
                updateRecords();
            }
        })
    });


    $(document).on("click", "#updateRecords", function () {
        updateRecords();
    });

    function updateRecords() {
        $.ajax({
            url: 'orderServing',
            type: 'GET',
            data: {'data': 'json', 'pageNumber': 0},
            error: function () {
                window.location.href = "/errorPage.jsp";
            },
            success: function (data) {
                console.log(data[1]);
                var ordersData = data[0];
                var drivers = data[1];
                var options = "";
                for (var i in drivers) {
                    var option = "<option value='" + drivers[i].id + "'>" +
                        "first name: " + drivers[i].firstName +
                        "| last name: " + drivers[i].lastName +
                        "| phone: " + drivers[i].phone +
                        "| available: " + drivers[i].available +
                        "| current location: " + drivers[i].currentLocation + "</option>";
                    options += option;
                }
                $("#driversList > *").remove();
                if (options.length > 0) {
                    $("#driversList").append(options);
                }
                var orders = orderRowsFromData(ordersData);
                $("#orders>tbody").remove();
                //<dl class="dl-horizontal">
                //</dl>
                disableIfLast(data[0]);
                var id = "page_" + ordersData.pageNumber;
                $("#orders").append("<tbody id=" + id + ">" + orders + "</tbody>");
            }
        });
    }

    /*//*//*

    $(document).on("click", "#orders tbody tr", function () {
        $("#orderId").val($(this).attr('id'));
        $(this).addClass("selected").siblings().removeClass("selected");
    });

    *//*var colNumber = 6 //number of table columns

     for (var i = 0; i < colNumber; i++) {
     var thWidth = $("table#orders").find("th:eq(" + i + ")").width();
     var tdWidth = $("table#orders").find("td:eq(" + i + ")").width();
     if (thWidth < tdWidth)
     $("table#orders").find("th:eq(" + i + ")").width(tdWidth);
     else
     $("table#orders").find("td:eq(" + i + ")").width(thWidth);
     }*//*

    if ($("#takeUp").length > 0) {
        $(".progress-tracker li:nth-child(1)").addClass("active");
    } else if ($("#clientExpecting").length > 0) {
        $(".progress-tracker li:nth-child(1), .progress-tracker li:nth-child(2) ").addClass("active");
    } else if ($("#start").length > 0) {
        $(".progress-tracker li:nth-child(1), .progress-tracker li:nth-child(2), .progress-tracker li:nth-child(3)")
            .addClass("active");
    } else if ($("#end").length > 0) {
        $(".progress-tracker li:nth-child(1), .progress-tracker li:nth-child(2), " +
        ".progress-tracker li:nth-child(3), .progress-tracker li:nth-child(4)").addClass("active");
    }*/
});
