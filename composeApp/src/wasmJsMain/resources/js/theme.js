// ===================================
// THEME MANAGEMENT
// ===================================
'use strict';

(function() {
    function detectTheme() {
        try {
            const cachedTheme = localStorage.getItem('dark_mode');

            if (cachedTheme !== null) {
                return cachedTheme === 'true';
            }

            return window.matchMedia('(prefers-color-scheme: dark)').matches;
        } catch (e) {
            log('Error detecting theme: ' + e.message, 'warn');
            return false;
        }
    }

    function applyTheme() {
        try {
            const isDarkMode = detectTheme();
            document.body.className = isDarkMode ? 'theme-dark' : 'theme-light';

            try {
                localStorage.setItem('dark_mode', isDarkMode.toString());
            } catch (e) {
                log('Cannot save theme preference: ' + e.message, 'warn');
            }

            log(`Theme applied: ${isDarkMode ? 'dark' : 'light'}`);
        } catch (e) {
            log('Error applying theme: ' + e.message, 'error');
        }
    }

    // Apply theme immediately
    applyTheme();

    // Listen for system theme changes
    try {
        window.matchMedia('(prefers-color-scheme: dark)').addEventListener('change', function(e) {
            if (localStorage.getItem('dark_mode') === null) {
                applyTheme();
            }
        });
    } catch (e) {
        log('Cannot listen to theme changes: ' + e.message, 'warn');
    }

    // Listen for storage changes (cross-tab theme sync)
    window.addEventListener('storage', function(e) {
        if (e.key === 'dark_mode') {
            applyTheme();
        }
    });

    // Export for external use
    window.ThemeManager = {
        apply: applyTheme,
        detect: detectTheme
    };
})();