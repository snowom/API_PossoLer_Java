window.addEventListener('load', ()=>{
    if(localStorage.getItem('msgRespai24') != 'true') { /* CRIA CHAVE PARA ARMAZENAR CONSENTIMENTO MSG */
        localStorage.setItem('msgRespai24', 'false');
        createSwalRespai(
            `<iframe src="/messageRespai" style="width: 100% !important; height: 100% !important; border: none;"></iframe>`
        )
    }
})


function createSwalRespai(msg)
{
    Swal.fire({
        html: msg,
        allowEscapeKey: false,
        allowOutsideClick: false,
        showConfirmButton: true,
        confirmButtonText: 'OK',
        customClass: {
            popup: 'popupAlertFerias',
            content: 'alertFerias',
            htmlContainer: 'alertFerias',
            container: 'containerAlertFerias'
        }
    }).then((result)=>{
        if(result.isConfirmed) localStorage.setItem('msgRespai24', 'true');
    });
}