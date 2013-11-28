var checkin = $('#dateOfStart').datepicker({
    onRender: function(date) {
        return '';
    }
}).on('changeDate', function(ev) {
    if (ev.date.valueOf() > checkout.date.valueOf()) {
        var newDate = new Date(ev.date);
        newDate.setDate(newDate.getDate() + 1);
        checkout.setValue(newDate);
    }
    checkin.hide();
    $('#dateOfCompletion')[0].focus();
}).data('datepicker');
var checkout = $('#dateOfCompletion').datepicker({
    onRender: function(date) {
        return date.valueOf() <= checkin.date.valueOf() ? 'disabled' : '';
    }
}).on('changeDate', function(ev) {
        checkout.hide();
}).data('datepicker');