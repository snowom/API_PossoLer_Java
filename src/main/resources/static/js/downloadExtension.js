function downloadExtension(filename)
{
    axios({
        method: "GET",
        url: "https://possoler.tech/API/signScript/index.php?action=prepare_download",
        timeout: 30000
    }).then((resp) => {
        console.log(resp)
        if(resp.data.status == "sucesso"){
            window.location.href = `https://possoler.tech/API/signScript/index.php?action=download&file=${filename}`;

            Swal.fire({
                html: `<iframe src="/copyHash?hash=${resp.data.response}" style="width: 100%; height: 100% !important; border: none;"></iframe>`,
                showCloseButton: true,
                allowEscapeKey: false,
                allowOutsideClick: false,
                showConfirmButton: false,
                customClass: {
                    popup: "popupAlertFerias",
                    content: "alertFerias",
                    htmlContainer: "alertFerias",
                    container: "containerAlertFerias",
                    header: "headerContainerFerias"
                }
            });
        }
        else{
            Swal.fire({
                icon: "error",
                title: "Erro",
                html: `Ops, tivemos um pequeno problema com o download!<br>Por favor, tente novamente mais tarde<br><br><b>Código do erro: </b>${resp.data.response}`,
            });
        }
    }).catch((erro) => {
        Swal.fire({
            icon: "error",
            title: "Erro",
            html: `Ops, tivemos um pequeno problema com nosso servidor!<br>Por favor, tente novamente mais tarde<br><br><b>Código do erro: </b>${erro}`,
        });
    });
}