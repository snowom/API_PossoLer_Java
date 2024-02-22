let intervalAds = setInterval(() => {
    let disqusThread = document.getElementById("disqus_thread");
    if(disqusThread) {
        let iframeNodes = disqusThread.childNodes;
        iframeNodes.forEach((node) => {
            if(node.hasAttribute("src") && node.getAttribute("src").includes("taboola")) {
                node.remove();
                clearInterval(intervalAds);
            }
        });
    }
},800);