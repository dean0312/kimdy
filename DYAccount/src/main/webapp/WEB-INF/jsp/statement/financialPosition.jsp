<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>재무상태표</title>
    <%-- jqGrid --%>
    <script type="text/ecmascript" src="${pageContext.request.contextPath}/assets/js/i18n/grid.locale-kr.js"></script>
    <script type="text/ecmascript" src="${pageContext.request.contextPath}/assets/js/jquery.jqGrid.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ui.jqgrid-bootstrap4.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/octicons/4.4.0/font/octicons.css">

    <script>
        $.jgrid.defaults.responsive = true;
        $.jgrid.defaults.styleUI = 'Bootstrap4';
        $.jgrid.defaults.iconSet = "Octicons";
    </script>

    <%--DatePicker--%>
    <link href="${pageContext.request.contextPath}/assets/css/datepicker.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/assets/js/datepicker.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/datepicker.ko-KR.js"></script>

    <script>
        var financialPositionGrid = "#financialPositionGrid";
        var rowsToColor = [];
        $.fn.fmatter.currency = function (cellValue, opts) {
            var currencyFormat = {
                defaultValue: '',
                decimalSeparator: '.',
                decimalPlaces: 0,
                thousandsSeparator: ',',
                prefix: '￦ '
            };

            if (cellValue == 0 || cellValue === null || cellValue === undefined) {
                return '';
            }

            return $.fmatter.util.NumberFormat(cellValue, currencyFormat);
        };

        $(document).ready(function () {
            $('[data-toggle="datepicker-to"]').datepicker({
                language: 'ko-KR',
                format: 'yyyy-mm-dd',
                autoPick: true,
                trigger: $('.docs-datepicker-to-trigger')
            });

            createFinancialPositionGrid();
        });

        function createFinancialPositionGrid() {
            $(financialPositionGrid).jqGrid({
                colModel: [
                    {name: "lev", label: "계층", hidden: true},
                    {name: "category", label: "분류", hidden: true},
                    {name: "accountName", label: "계정과목", width: 200},
                    {
                        name: "balanceDetail",
                        label: "세부금액",
                        width: 200,
                        formatter: "currency"
                    },
                    {
                        name: "balanceSummary",
                        label: "합계금액",
                        width: 200,
                        formatter: "currency"
                    },
                    {
                        name: "preBalanceDetail",
                        label: "세부금액",
                        width: 200,
                        formatter: "currency"
                    },
                    {
                        name: "preBalanceSummary",
                        label: "합계금액",
                        width: 200,
                        formatter: "currency"
                    }
                ],
                shrinkToFit: false,
                viewrecords: true,
                autowidth: true,
                height: 562,
                rowNum: 9999,
                datatype: 'local',
                gridComplete: function () {
                    var rows = $(financialPositionGrid).getDataIDs();

                    for (var i = 0; i < rows.length; i++) {
                        var lev = $(financialPositionGrid).jqGrid("getCell", rows[i], "lev");

                        if (lev == 0)
                            $(financialPositionGrid).jqGrid('setRowData', rows[i], false, {background: '#CCC'});
                        else if (lev == 1)
                            $(financialPositionGrid).jqGrid('setRowData', rows[i], false, {background: '#EEE'});
                    }
                }
            }).jqGrid("setGroupHeaders", {
                useColSpanStyle: true,
                groupHeaders: [
                    {numberOfColumns: 2, titleText: "당기", startColumnName: "balanceDetail"},
                    {numberOfColumns: 2, titleText: "전기", startColumnName: "preBalanceDetail"}]
            });
            ;
        }

        function showFinancialPosition() {
            $(financialPositionGrid).jqGrid("clearGridData");

            // show loading message
            $(financialPositionGrid)[0].grid.beginReq();
            $.ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/statement/financialPosition.do",
                data: {
                    toDate: $("#toDate").val()
                },
                dataType: "json",
                success: function (jsonObj) {
                    // set the new data
                    $(financialPositionGrid).jqGrid('setGridParam', {data: jsonObj.financialPosition});
                    // hide the show message
                    $(financialPositionGrid)[0].grid.endReq();
                    // refresh the grid
                    $(financialPositionGrid).trigger('reloadGrid');
                }
            });
        }
    </script>
</head>
<body>
    <div class="col-12">
        <div class="card">
            <div class="card-body">
                <div class="form-row ml-0">
                    <div class="docs-datepicker mr-1">
                        <div class="input-group">
                            <input id="toDate" type="date" class="form-control form-control-sm docs-date"
                                   data-toggle="datepicker-to" required>
                            <div class="input-group-append">
                                <button type="button"
                                        class="form-control form-control-sm btn btn-outline-secondary docs-datepicker-to-trigger">
                                    <i style="color:#FD7D86;" class="fa fa-calendar" aria-hidden="true"></i>
                                </button>
                            </div>
                        </div>
                    </div>

                    <div>
                        <button type="button" id="search"
                                class="form-control form-control-sm btn btn-flat btn-outline-dark mb-3"
                                onclick="showFinancialPosition();">
                            조회
                        </button>
                    </div>
                </div>
                <table id="financialPositionGrid"></table>
            </div>
        </div>
    </div>

</body>
</html>
