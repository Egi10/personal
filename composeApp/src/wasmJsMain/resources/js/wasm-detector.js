// ===================================
// WASM DETECTION
// ===================================
'use strict';

window.WasmDetector = (function() {
    const config = window.AppConfig;
    const state = window.AppState;

    function checkWasmLoaded() {
        if (state.isWasmLoaded || state.errorOccurred) {
            return;
        }

        // Multiple detection methods for different WASM frameworks
        const detectionMethods = [
            function() { return typeof window.wasmExports !== 'undefined'; },
            function() { return typeof window.Module !== 'undefined'; },
            function() { return typeof window.ComposeApp !== 'undefined'; },
            function() { return document.querySelector('canvas') !== null; },
            function() {
                const mainContent = document.getElementById('main-content');
                return mainContent && mainContent.children.length > 0;
            },
            function() { return document.body.children.length > 3; }
        ];

        const isLoaded = detectionMethods.some(function(method) {
            try {
                return method();
            } catch (e) {
                return false;
            }
        });

        if (isLoaded) {
            log('WASM detected as loaded');
            state.isWasmLoaded = true;
            window.ErrorManager.clearTimers();
            window.LoadingManager.hide();
        }
    }

    function startChecking() {
        state.checkInterval = setInterval(checkWasmLoaded, config.checkInterval);
    }

    function setupTimeout() {
        state.loadTimeout = setTimeout(function() {
            if (!state.isWasmLoaded) {
                log('Maximum loading time exceeded', 'warn');
                window.ErrorManager.show('timeout');
            }
        }, config.maxLoadingTime);
    }

    return {
        check: checkWasmLoaded,
        startChecking: startChecking,
        setupTimeout: setupTimeout
    };
})();

// Public API for manual WASM ready notification
window.wasmReady = function() {
    log('wasmReady() called');
    window.AppState.isWasmLoaded = true;
    window.ErrorManager.clearTimers();
    window.LoadingManager.hide();
};