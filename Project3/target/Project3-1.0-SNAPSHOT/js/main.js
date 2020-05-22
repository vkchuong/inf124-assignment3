function sendEmail() {
    document.getElementById("contactform").action = "mailto:info@sportsstore.com";
}


// using jQuery and Ajax for form autocomplete
var taxRate = 0;
var shipping = 9.50;
if (document.getElementById('total-price') !== null) {
    var total = parseFloat(document.getElementById('total-price').innerHTML.substring(1));
}
$(document).ready(function() {
    $('#state').keyup(function() {
        var state = $(this).val();
        if (state !== '') {
            $.ajax({
                url: "./state",
                method: "GET",
                data: {
                    state: state
                },
                success: function(data) {
                    $('#stateList').html(data);
                }
            });
        }
    });
    $(document).on('click', 'li', function() {
        $('#state').val($(this).text());
        $('#stateList').fadeOut();
    });


    $('#zip').keyup(function() {
        var zip = $(this).val();
        if (zip.length > 3) {
            $.ajax({
                url: "./tax",
                method: "GET",
                data: {
                    zip: zip
                },
                success: function(data) {
                    $('#tax-rate').html(data);
                    taxRate = parseFloat(data).toFixed(3);
                    if(isNaN(taxRate))
                        taxRate = 0.09;
                    displayPrice();
                }
            });
        }
    });


    $('#method').change(function() {
        var choice = $(this).val();
        if (choice === "Overnight ($11.00)") {
            shipping = 11.00;
        }
        if (choice === "2-day expedited ($9.50)") {
            shipping = 9.50;
        }
        if (choice === "7-day ground ($6.25)") {
            shipping = 6.25;
        }
        displayPrice();
    });
    
    const displayPrice = () =>{
        $('#total-price').html(total);
        $('#tax-amount').html((total * taxRate).toFixed(2));
        let final = (total + (total * taxRate) + shipping);
        $('#shipping').html(shipping.toFixed(2));
        $('#final-price').html(final.toFixed(2));
        $('input[id=totalPrice]').val(final.toFixed(2));
    };
    displayPrice();

    // billing address
    $('#billing-address').hide();

    $('#same-address').change(function() {
        $('#billing-address').slideToggle();
    })
});

function startCountdown() {
    var countDownDate = new Date("May 21, 2020 23:59:59").getTime();
    var x = setInterval(function() {
        var now = new Date().getTime();
        var distance = countDownDate - now;
        var days = Math.floor(distance / (1000 * 60 * 60 * 24));
        var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
        var seconds = Math.floor((distance % (1000 * 60)) / 1000);
        document.getElementsByClassName("countdown")[0].innerHTML = ("0" + days).slice(-2) + " DAYS, " + ("0" + hours).slice(-2) + " HOURS, " + ("0" + minutes).slice(-2) + " MINS, " + ("0" + seconds).slice(-2) + " SECS ";
        if (distance < 0) {
            clearInterval(x);
            document.getElementsByClassName("countdown")[0].innerHTML = "EXPIRED";
        }
    }, 1000);
}