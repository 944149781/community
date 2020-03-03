function post() {
    var parent_id = $("#parent_id").val();
    var content = $("#content").val();
    console.log(content);
    console.log(parent_id);
    $.ajax({
        type:"POST",
        url:"/comment",
        contentType:"application/json",
        data:JSON.stringify({
            "parent_id": parent_id,
            "content": content,
            "type": 1
        }),
        dataType:"json"
    });
}