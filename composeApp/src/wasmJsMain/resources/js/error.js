// ===================================
// ERROR HANDLING
// ===================================
'use strict';

window.ErrorManager = (function() {
    const config = window.AppConfig;
    const state = window.AppState;

    function clearAllTimers() {
        if (state.loadTimeout) {
            clearTimeout(state.loadTimeout);
            state.loadTimeout = null;
        }
        if (state.checkInterval) {
            clearInterval(state.checkInterval);
            state.checkInterval = null;
        }
        if (state.textInterval) {
            clearInterval(state.textInterval);
            state.textInterval = null;
        }
    }

    function showErrorScreen(errorType = 'timeout') {
        if (state.errorOccurred) return;

        state.errorOccurred = true;
        clearAllTimers();

        const loadingScreen = document.getElementById('loading-screen');
        if (!loadingScreen) return;

        log('Showing error screen: ' + errorType, 'error');

        const errorMessage = config.errorMessages[errorType] || config.errorMessages.general;

        loadingScreen.innerHTML = `
            <div class="error-container" role="alert">
                <div class="error-icon" aria-hidden="true">⚠️</div>
                <h1 class="error-title">Failed to Load Application</h1>
                <p class="error-message">${errorMessage}</p>

                <div class="error-details">
                    <div class="error-details-title">Possible causes:</div>
                    <ul class="error-list">
                        <li>Slow or unstable internet connection</li>
                        <li>Browser compatibility issues</li>
                        <li>WebAssembly not supported</li>
                        <li>Ad blocker or security extension interference</li>
                        <li>Corrupted cache or cookies</li>
                    </ul>
                </div>

                <div class="error-actions">
                    <button onclick="location.reload()" class="btn btn-primary">
                        🔄 Retry
                    </button>
                    <button onclick="window.clearCacheAndReload()" class="btn btn-secondary">
                        🗑️ Clear Cache & Retry
                    </button>
                </div>
            </div>
        `;

        loadingScreen.setAttribute('role', 'alert');
        loadingScreen.setAttribute('aria-live', 'assertive');
    }

    return {
        show: showErrorScreen,
        clearTimers: clearAllTimers
    };
})();

// Global error handlers
window.handleScriptError = function(event) {
    log('Script loading error detected', 'error');
    window.ErrorManager.show('script');
};

window.onerror = function(msg, url, lineNo, columnNo, error) {
    if (url && url.includes('composeApp.js')) {
        log(`Script error: ${msg}`, 'error');
        window.ErrorManager.show('script');
    }
};

// Clear cache utility
window.clearCacheAndReload = function() {
    try {
        localStorage.clear();
        sessionStorage.clear();

        if ('caches' in window) {
            caches.keys().then(function(names) {
                names.forEach(function(name) {
                    caches.delete(name);
                });
            }).finally(function() {
                location.reload(true);
            });
        } else {
            location.reload(true);
        }
    } catch (e) {
        log('Error clearing cache: ' + e.message, 'error');
        location.reload(true);
    }
};