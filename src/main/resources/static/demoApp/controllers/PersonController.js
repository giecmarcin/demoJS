function save() {
    //get the form values
    var name = $('#name').val();
    var lastName = $('#lastName').val();
    var age = $('#age').val();

    $.ajax({
            type: "POST",
            url: "/add",
            data: JSON.stringify({
                id:0,
                name: "Gerry",
                lastName: "Sydney",
                age:20
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            success: function (data) {
                alert('Person was added');
            },
            error: function (data) {
                alert('Error: ' + JSON.stringify(data));
            }
        }
    );
}
