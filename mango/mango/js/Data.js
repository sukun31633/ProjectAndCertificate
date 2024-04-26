var type;

$(document).ready(()=>{

    $.ajax({
        method: 'get',
        url: './api/getallproduct.php',
        success: function (response) {
            console.log(response)
            if (response.RespCode == 200) {

                type = response.Result;

                var html = '';
                for (let i = 0; i < type.length; i++) {
                    html += `<div onclick="openProductDetail(${i})" class="selectData ${type[i].name}">
                                <p style="font-size: 1.5vw;">${type[i].name}</p>
                            </div>`;
                }
                $('#conjs').html(html);
            }
        }, error: function (err) {
            console.log(err)
        }
    })
})

function search(text) {
    var value = $('#'+text.id).val();
    console.log(value);

    var html = '';
    for(let i=0;i<type.length;i++) {
        if(type[i].name.includes(value)){
            html += `<div onclick="openProductDetail(${i})" class="selectData ${type[i].name}">
        <p style="font-size: 1.5vw;">${type[i].name}</p>
        <img src="./img/${type[i].img}">
    </div>`;
        }
    }
    $('#conjs').html(html);
}

function searchdata(data) {
    console.log(data);
    $(".selectData").css('display','none')
    if(data == 'All'){
        $(".selectData").css('display','block')
    }
    else{
        $("."+data).css('display','block')
    }
}

var productindex = 0;
function openProductDetail(index) {
    productindex = index;
    console.log(productindex)
    $("#modalDesc").css('display', 'flex')
    var html = '';

        html += `<div onclick="closeModal()" class="modal-bg"></div>
        <div class="modal-page">
            <br>
            <div class="modaldesc-content">
                <div class="modaldesc-detail">
                    <p id="mdd-name" style="font-size: 2vw;" class="modal-font">${type[index].name}</p>
                    <br>
                    <img src="./img/${type[index].img}">
                    <br>
                    <p id="mdd-desc" style="font-size: 1.2vw;" class="modal-font">${type[index].info}</p>
                    <br>
                    <div class="btn-control">
                        <button onclick="closeModal()" class="btn">
                            Close
                        </button>
                    </div>
                </div>
            </div>
        </div>`;

    $('#modalDesc').html(html);
}

function closeModal() {
    $(".modal").css('display', 'none')
}
