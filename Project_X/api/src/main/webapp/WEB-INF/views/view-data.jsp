<html>
<head>
    <title>Highcharts Tutorial</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="http://code.highcharts.com/highcharts.js"></script>
    <script src="https://www.highcharts.com/samples/static/highslide-full.min.js"></script>
    <script src="https://www.highcharts.com/samples/static/highslide.config.js" charset="utf-8"></script>
    <link rel="stylesheet" type="text/css" href="https://www.highcharts.com/samples/static/highslide.css" />
    <script src="https://code.highcharts.com/modules/data.js"></script>
    <script src="https://code.highcharts.com/modules/exporting.js"></script>

</head>
<body>
<div id="container" style="width: 1000px; height: 700px; margin: 0 auto"></div>
<script language="JavaScript">
    $(document).ready(function() {

        function refresh() {

            // Get the CSV and create the chart
            $.get('http://localhost:5555/home/get', function (csv) {

                $('#container').highcharts({

                    data: {
                        csv: csv
                    },

                    title: {
                        text: 'Inertial Data'
                    },

                    yAxis: [{ // left y axis
                        title: {
                            text: 'Values'
                        },
                        labels: {
                            align: 'left',
                            x: 3,
                            y: 16,
                            format: '{value:.,0f}'
                        },
                        showFirstLabel: false
                    },],

                    legend: {
                        align: 'left',
                        verticalAlign: 'top',
                        y: 20,
                        floating: true,
                        borderWidth: 0
                    },

                    tooltip: {
                        shared: true,
                        crosshairs: true
                    },
                });
            });
        };
        refresh();
        setInterval(refresh, 5000);
//
    });
</script>
</body>
</html>









