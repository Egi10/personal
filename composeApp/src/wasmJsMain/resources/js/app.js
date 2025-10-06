// ===================================
// MAIN APPLICATION INITIALIZATION
// ===================================
'use strict';

(function() {
    log('Initializing application');

    // Start loading text updates
    window.LoadingManager.startTextUpdate();

    // Start WASM detection
    window.WasmDetector.startChecking();

    // Setup timeout for error handling
    window.WasmDetector.setupTimeout();

    // Listen for page load events
    if (document.readyState === 'loading') {
        document.addEventListener('DOMContentLoaded', window.WasmDetector.check);
    } else {
        window.WasmDetector.check();
    }

    window.addEventListener('load', window.WasmDetector.check);

    // Visibility change detection (check when tab becomes visible)
    document.addEventListener('visibilitychange', function() {
        if (!document.hidden && !window.AppState.isWasmLoaded && !window.AppState.errorOccurred) {
            window.WasmDetector.check();
        }
    });

    log('Initialization complete');
})();