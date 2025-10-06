// ===================================
// LOADING SCREEN MANAGEMENT
// ===================================
'use strict';

window.LoadingManager = (function() {
    const config = window.AppConfig;
    const state = window.AppState;

    function updateLoadingText() {
        const loadingTextElement = document.getElementById('loading-text');

        if (loadingTextElement && !state.isWasmLoaded && !state.errorOccurred) {
            const text = config.loadingTexts[state.currentTextIndex];
            loadingTextElement.innerHTML = `${text}<span class="loading-dots">...</span>`;
            state.currentTextIndex = (state.currentTextIndex + 1) % config.loadingTexts.length;
        }
    }

    function hideLoadingScreen() {
        const loadingScreen = document.getElementById('loading-screen');
        const mainContent = document.getElementById('main-content');

        if (!loadingScreen || !mainContent) return;

        const elapsedTime = Date.now() - state.loadingStartTime;
        const remainingTime = Math.max(0, config.minLoadingTime - elapsedTime);

        log(`Hiding loading screen in ${remainingTime}ms`);

        setTimeout(function() {
            loadingScreen.classList.add('hidden');
            mainContent.classList.add('loaded');

            loadingScreen.setAttribute('aria-hidden', 'true');
            mainContent.removeAttribute('aria-hidden');

            setTimeout(function() {
                if (loadingScreen.parentNode) {
                    loadingScreen.remove();
                }
            }, 500);
        }, remainingTime);
    }

    function startLoadingTextUpdate() {
        state.textInterval = setInterval(updateLoadingText, config.loadingTextInterval);
    }

    return {
        hide: hideLoadingScreen,
        startTextUpdate: startLoadingTextUpdate
    };
})();